package com.mahbubalam.springtestcaseservice.config;


import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConsumerConfig {

    @Value("${rabbitmq.queue.receive.name}")
    private String queue;
    @Value("${rabbitmq.exchange.compiler.exchange.name}")
    private String compilerExchange;
    @Value("${rabbitmq.testCaseWith.compiler.routing.key}")
    private String routingKey;


    public Queue queue(){
     return new Queue(queue);
 }

    @Bean
    public TopicExchange compilerExchange() {
        return new TopicExchange(compilerExchange);
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue())
                .to(compilerExchange())
                .with(routingKey);
    }

    @Bean
    public MessageConverter converter(){
        return new Jackson2JsonMessageConverter();
    }


    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory){

        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}