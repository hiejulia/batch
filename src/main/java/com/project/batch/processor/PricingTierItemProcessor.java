package com.project.batch.processor;

import java.util.ArrayList;
import java.util.List;

import com.project.batch.entity.AccountTransactionQuantity;
import com.project.batch.entity.PricingTier;
import org.springframework.batch.item.ItemProcessor;


// Pricing Tier Item Processor
public class PricingTierItemProcessor implements ItemProcessor<AccountTransactionQuantity, AccountTransactionQuantity> {

    private List<Integer> accountsProcessed = new ArrayList<Integer>();

    // process:

    public AccountTransactionQuantity process(AccountTransactionQuantity atq)
            throws Exception {

        if(atq.getTransactionCount() <= 1000) {
            atq.setTier(PricingTier.I);
        } else if(atq.getTransactionCount() > 1000 && atq.getTransactionCount() <= 100000) {
            atq.setTier(PricingTier.II);
        } else if(atq.getTransactionCount() > 100000 && atq.getTransactionCount() <= 1000000) {
            atq.setTier(PricingTier.III);
        } else {
            atq.setTier(PricingTier.IV);
        }
        return atq;
    }


    // Add tiers -
    private void addTiers(PricingTier tier, long qty) {
        for(int i = 0; i < qty * 1000000; i++) {
            if(i % 1000 == 0) {
                // accountProcess - bo tay cho con be nay - no di cua nhung thanh phan khac nua
                accountsProcessed.add(tier.getValue());
            }
        }
        int total = 0;
        for (Integer currentTier : accountsProcessed) {
            total += currentTier;
        }
    }
}