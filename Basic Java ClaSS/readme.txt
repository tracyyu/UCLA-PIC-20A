Tracy Yu

Homework 3

A challenge I faced with the homework is the understanding of inheritance. When I was 
writing code for the withdraw and transfer method in the FreeSavingsAccount, I did not realize the code
in the transfer method of BankAccount would call the withdraw and deposit in the FreeSavings Account. This
caused my program to double count the number of withdraws and my feeCount. This is because I included code that would
add up feeCount whenever my program called withddraw and transfer.