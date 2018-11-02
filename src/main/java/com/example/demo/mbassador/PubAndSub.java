package com.example.demo.mbassador;

import net.engio.mbassy.bus.MBassador;
import net.engio.mbassy.bus.config.BusConfiguration;
import net.engio.mbassy.bus.config.Feature;
import net.engio.mbassy.bus.config.IBusConfiguration;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;

import java.util.concurrent.TimeUnit;

/**
 * @author wxq
 * @date 2018-10-31
 */
public class PubAndSub<T> {
    MBassador<T> bus = new MBassador<T>(new BusConfiguration()
            .addFeature(Feature.SyncPubSub.Default())
            .addFeature(Feature.AsynchronousHandlerInvocation.Default())
            .addFeature(Feature.AsynchronousMessageDispatch.Default())
            .addPublicationErrorHandler(new IPublicationErrorHandler.ConsoleLogger())
            .setProperty(IBusConfiguration.Properties.BusId, "global bus")); // this is used for identification in #toString

    /**
     * 增加多个同样的listener只会当做一个，没有handler的会自动忽略
     *
     * @param listener
     * @return
     */
    public MBassador addListener(Object listener) {
        bus.subscribe(listener);
        return bus;
    }

    public MBassador puclishAsync(T message) {
        bus.publishAsync(message, 10, TimeUnit.MINUTES);
//        bus.post(message).asynchronously(); //same as above
        return bus;
    }

    public MBassador puclishSync(T message) {
        bus.publish(message);
//        bus.post(message).now(); //same as above
        return bus;
    }
}
