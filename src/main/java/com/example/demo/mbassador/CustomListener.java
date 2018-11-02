package com.example.demo.mbassador;

import net.engio.mbassy.bus.MessagePublication;
import net.engio.mbassy.dispatch.HandlerInvocation;
import net.engio.mbassy.listener.*;
import net.engio.mbassy.subscription.SubscriptionContext;

import java.io.File;

/**
 * @author wxq
 * @date 2018-10-31
 */
@Listener(references = References.Weak)
public class CustomListener {

    @Handler(invocation = TimingInvocation.class, filters = {@Filter(Urlfilter.class)})
    @Enveloped(messages = {File.class})
    public void handle(File message) {
        System.out.println(message.getName());
    }


    public static class TimingInvocation extends HandlerInvocation<CustomListener, File> {

        public TimingInvocation(SubscriptionContext context) {
            super(context);
        }


        @Override
        public void invoke(CustomListener customListener, File file, MessagePublication messagePublication) {
            long start = System.currentTimeMillis();
            customListener.handle(file);
            long duration = System.currentTimeMillis() - start;
            System.out.println("Time takes for handler invocation: " + duration + " ms");
        }
    }

    static class Urlfilter implements IMessageFilter<String> {
        @Override
        public boolean accepts(String message, SubscriptionContext context){
            return message.startsWith("http");
        }
    }
}
