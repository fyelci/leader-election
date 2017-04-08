package com.fyelci.leaderelection;


import org.jgroups.Address;
import org.jgroups.JChannel;
import org.jgroups.ReceiverAdapter;
import org.jgroups.View;

/**
 * Create an instance and call start method to start a node
 *
 * Created by fatihyelci on 27.02.2017.
 */
public class LeaderElection extends ReceiverAdapter {

    JChannel channel;

    private final Long sleeepDuration;

    public LeaderElection(Long sleeepDuration) {
        this.sleeepDuration = sleeepDuration;
    }

    /**
     * If not exists creates LeaderElectionAssignmentCluster cluster.
     * If exists, it joins the cluster.
     *
     * @throws Exception
     */
    public void start() throws Exception {
        channel = new JChannel("udp.xml");
        channel.setReceiver(this);
        channel.connect("LeaderElectionCluster");
        checkLeaderStatus();
        sleep();
        channel.close();
    }

    /**
     * Infinite loop for to force channel wait
     */
    private void sleep() {
        try {
            Thread.sleep(sleeepDuration);
        } catch (Exception e) {
            System.err.println("Exception occured while infinite loop: " + e.getMessage());
        }
    }

    /**
     * Allways first joined node is master. This mehod prints message only once.
     */
    private void checkLeaderStatus() {
        Address address = channel.getView().getMembers().get(0);
        if (address.equals(channel.getAddress())) {
            System.out.println("Nodes are started, I'm the master!");
        }
    }

    @Override
    public void viewAccepted(View newView) {
        System.out.println("One more node joined. Current node size is: " + newView.getMembers().size());
    }

}
