package com.example.sharingapp;

import android.content.Context;

/**
 * Command to add a bid
 */
public class AddBidCommand extends Command {

    private Bid bid;

    public AddBidCommand( Bid bid) {
        this.bid = bid;
    }

    // Save bid locally
    public void execute(){
       ElasticSearchManager.AddBidTask addbid=new ElasticSearchManager.AddBidTask();
       addbid.execute(bid);
    }
}
