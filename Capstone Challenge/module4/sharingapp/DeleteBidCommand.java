package com.example.sharingapp;


/**
 * Command to delete a bid
 */
public class DeleteBidCommand extends Command {

    
    private Bid bid;
    
    public DeleteBidCommand(Bid bid) {
       
        this.bid = bid;
 
    }

    // Delete bid locally
    public void execute(){
      ElasticSearchManager.RemoveBidTask removeBid=new ElasticSearchManager.RemoveBidTask();
      removeBid.execute(bid);
    }
}