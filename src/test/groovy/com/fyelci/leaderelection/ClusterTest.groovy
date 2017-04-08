package com.fyelci.leaderelection
/**
 * Dummy test.
 *
 * @author Fatih Yelci
 * @since 27.02.2017
 */
class ClusterTest extends AbstractTest {

    def "Test joining cluster"() {
        when:
        LeaderElection cluster = new LeaderElection(5000L);
        cluster.start();

        then:
        assert outContent.toString().contains("We are started!");
    }
}
