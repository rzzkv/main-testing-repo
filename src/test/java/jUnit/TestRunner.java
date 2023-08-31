package jUnit;

import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

public class TestRunner {

    public static void main(String[] args) {
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        LauncherFactory.create().execute(
                     LauncherDiscoveryRequestBuilder
                                           .request()
                                           .selectors(selectClass(JUnitSimpleTest.class))
                                           .build(),
                                   listener
                );

        TestExecutionSummary summary = listener.getSummary();
        printSummary(summary);
    }

    private static void printSummary(TestExecutionSummary summary) {
        System.out.println("Total tests: " + summary.getContainersFoundCount());
        System.out.println("Successful tests: " + summary.getTestsSucceededCount());
        System.out.println("Failed tests: " + summary.getTestsFailedCount());
        System.out.println("Aborted tests: " + summary.getTestsAbortedCount());
    }
}