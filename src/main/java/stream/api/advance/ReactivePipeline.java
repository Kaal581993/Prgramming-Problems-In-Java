package stream.api.advance;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.stream.Stream;

public class ReactivePipeline {
    public static void main(String[] args) throws InterruptedException {
        // Problem 13: Create reactive processing pipeline (conceptual using Flow API).
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();

        // The subscriber defines the processing pipeline for each item.
        Flow.Subscriber<String> subscriber = new Flow.Subscriber<>() {
            private Flow.Subscription subscription;
            public void onSubscribe(Flow.Subscription s) { subscription = s; subscription.request(1); }
            public void onNext(String item) {
                // The stream pipeline is applied to each individual item as it arrives.
                Stream.of(item)
                      .map(String::toUpperCase)
                      .forEach(processed -> System.out.println("Processed: " + processed));
                subscription.request(1);
            }
            public void onError(Throwable t) { t.printStackTrace(); }
            public void onComplete() { System.out.println("Pipeline complete."); }
        };

        publisher.subscribe(subscriber);

        System.out.println("Publishing data to the reactive stream...");
        List.of("one", "two", "three").forEach(publisher::submit);
        publisher.close();
        
        // Wait for the async processing to finish in this demo
        Thread.sleep(100);
    }
}
