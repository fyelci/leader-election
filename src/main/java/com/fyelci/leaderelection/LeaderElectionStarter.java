package com.fyelci.leaderelection;

/**
 * Main starter class
 */
public final class LeaderElectionStarter {

  private LeaderElectionStarter() {

  }

  public static void main(String[] args) throws Exception {
    LeaderElection sample = new LeaderElection(Long.MAX_VALUE);
    sample.start();
  }

}
