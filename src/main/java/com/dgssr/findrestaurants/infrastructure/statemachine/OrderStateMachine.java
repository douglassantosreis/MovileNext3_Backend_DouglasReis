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
                .states(EnumSet.allOf(OrderStates.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<OrderStates, OrderEvents> transitions)
            throws Exception {
        transitions
            .withExternal()
                .source(OrderStates.OPEN).target(OrderStates.OPEN)
                .event(OrderEvents.OPEN);
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