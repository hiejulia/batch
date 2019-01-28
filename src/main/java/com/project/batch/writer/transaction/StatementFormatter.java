package com.project.batch.writer.transaction;


import java.text.NumberFormat;

import com.project.batch.entity.Customer;
import com.project.batch.entity.Statement;
import org.springframework.batch.item.file.transform.LineAggregator;


public class StatementFormatter implements LineAggregator<Statement> {

    private static final String ADDRESS_FORMAT = "%s %s\n%s\n%s, %s %s\n\n";
    private static final String SUMMARY_HEADER_FORMAT = "Account Number   %s\n"
            + "\nYour Account Summary\n\n";
    private static final String SUMMARY_FORMAT = "Market Value of Current Securities"
            + "                             %s\nCurrent Cash Balance                   "
            + "                             %s\nTotal Account Value                     "
            + "                       %s\n\n";
    private static final String CASH_DETAIL_FORMAT = "Account Detail\n\nCash        "
            + "                                              %s\n\nSecurities\n\n";
    private static final String SECURITY_HOLDING_FORMAT = "     %s                  "
            + "     %s                           %s\n";
    private static NumberFormat moneyFormatter = NumberFormat
            .getCurrencyInstance();


    // Aggregrate - statement
    public String aggregate(Statement statement) {
        StringBuilder output = new StringBuilder();

        formatAddress(statement, output);
        formatSummary(statement, output);
        formatDetails(statement, output);

        return output.toString();
    }

    private void formatDetails(Statement statement, StringBuilder output) {
        output.append(String.format(CASH_DETAIL_FORMAT,
                new Object[] { statement.getCustomer().getAccount()
                        .getCashBalance() }));
        for (Transaction transaction : statement.getStocks()) {
            output.append(String.format(SECURITY_HOLDING_FORMAT, new Object[] {
                    transaction.getTicker(), transaction.getQuantity(),
                    moneyFormatter.format(transaction.getDollarAmount()) }));
        }
    }

    private void formatSummary(Statement statement, StringBuilder output) {
        output.append(String.format(SUMMARY_HEADER_FORMAT,
                new Object[] { statement.getCustomer().getAccount()
                        .getAccountNumber() }));
        output.append(String.format(
                SUMMARY_FORMAT,
                new Object[] {
                        moneyFormatter.format(statement.getSecurityTotal().doubleValue()),
                        moneyFormatter.format(statement.getCustomer()
                                .getAccount().getCashBalance().doubleValue()),
                        moneyFormatter.format(statement.getCustomer()
                                .getAccount().getCashBalance().doubleValue()
                                + statement.getSecurityTotal().doubleValue()) }));
    }


    // Format Address
    private void formatAddress(Statement statement, StringBuilder output) {
        // Ng
        Customer customer = statement.getCustomer();

        output.append(String.format(ADDRESS_FORMAT,
                new Object[] { customer.getFirstName(), customer.getLastName(),
                        customer.getAddress().getAddress1(),
                        customer.getAddress().getCity(),
                        customer.getAddress().getState(),
                        customer.getAddress().getZip() }));
    }
}