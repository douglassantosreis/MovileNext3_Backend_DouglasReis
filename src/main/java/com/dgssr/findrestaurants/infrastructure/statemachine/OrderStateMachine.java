package com.dgssr.findrestaurants.infrastructure.statemachine;


import java.util.EnumSet;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;
import org.springframework.statemachine.state.State;

@Configuration
@EnableStateMachine
public class OrderStateMachine extends EnumStateMachineConfigurerAdapter<OrderStates, OrderEvents> {

    @Override
    public void configure(StateMachineStateConfigurer<OrderStates, OrderEvents> states)
            throws Exception {
        states
            .withStates()
                .initial(OrderStates.OPEN)
                .end(OrderStates.DELIVERED)
                .states(EnumSet.allOf(OrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(OrderStates.OPEN).target(OrderStates.OPEN).event(OrderEvents.OPEN)
                .and()
            .withExternal()
            	.source(OrderStates.IN_ANALYSIS).target(OrderStates.PAYMENT_ACCEPT).event(OrderEvents.ROUTE)
            	.and()
            .withExternal()
            	.source(OrderStates.IN_ANALYSIS).target(OrderStates.PAYMENT_REJECTED).event(OrderEvents.CANCELED)
            	.and()
            .withExternal()
                .source(OrderStates.IN_ANALYSIS).target(OrderStates.ON_ROUTE).event(OrderEvents.ROUTE)
                .and()
            .withExternal()
                .source(OrderStates.ON_ROUTE).target(OrderStates.DELIVERED).event(OrderEvents.CLOSED);
    }
    @Override
	public void configure(StateMachineConfigurationConfigurer<OrderStates, OrderEvents> config) throws Exception {
		config
			.withConfiguration()
			.autoStartup(true)
			.listener(new StateMachineListener());
	}
	
	private static final class StateMachineListener extends StateMachineListenerAdapter<OrderStates, OrderEvents> { 
		  @Override 
		  public void stateChanged(State<OrderStates, OrderEvents> from, State<OrderStates, OrderEvents> to) {
			   System.out.println(to);
		  }
		  
	}
}