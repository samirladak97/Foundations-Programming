public class YearlyBudget{
  public static void main(String[] args){
    double income = Double.parseDouble(args[0]);
    double creditBalance = Double.parseDouble(args[1]);
    double interestRate = Double.parseDouble(args[2]);
    long creditCardNumber = Long.parseLong(args[3]);
    double monthlyRent = Double.parseDouble(args[4]);
    double[] expenses = buildExpenses(monthlyRent);    
    double postTaxIncome = calculateTax(income,10000,20,20000,30,45000,50);    
    double [] monthPayment = (buildPayments(postTaxIncome));

    //First check if credit card is valid
    if(validateCreditCard(creditCardNumber) == true){
    //if credit card is valid print monthly credit card balances
      System.out.println("Monthly Credit Card Balances:");
      printBalance(creditBalance, interestRate, expenses, monthPayment);
      //for monthly savings I used post tax income - interest payed (Dan's option #1 on MyCourses
      System.out.println("Monthly Savings: " + monthlySavings((postTaxIncome*((interestRate/12)/100)), (postTaxIncome/12)) + "$ per month");
      //total yearly savings
      System.out.println("Total Savings: " + monthlySavings((postTaxIncome*(interestRate/100)), postTaxIncome) + "$ per year");
    }
    //if credit card is not valid print "Invalid Card"
    else{
      System.out.println("Invalid Card");
    }
  }  
  
  //code to calculate amount of tax based on yearly income
  public static double calculateTax(double yearlyIncome, double bracket1Dollars, double bracket1Rate, double bracket2Dollars, double bracket2Rate, double bracket3Dollars, double bracket3Rate){
    double tax = 0.0;
    if(yearlyIncome <= bracket1Dollars){
      tax = 0;
      return tax;
    }
    else if((yearlyIncome > bracket1Dollars) && (yearlyIncome <= bracket2Dollars)){
      tax = (yearlyIncome - bracket1Dollars)*(bracket1Rate/100);
      return tax;
    }
    else if((yearlyIncome > bracket2Dollars) && (yearlyIncome <= bracket3Dollars)){
      tax = (bracket2Dollars - bracket1Dollars)*(bracket1Rate/100) + (yearlyIncome - bracket2Dollars)*(bracket2Rate/100);
      return tax;
    }  
    else{
      tax = (bracket2Dollars - bracket1Dollars)*(bracket1Rate/100) + (bracket3Dollars - bracket2Dollars)*(bracket2Rate/100) + (yearlyIncome - bracket3Dollars)*(bracket3Rate/100);
      return tax;
    } 
  }  
  
  //code to calculate amout saved per year after taxes and expenses
  public static double monthlySavings(double monthlyExpenses, double monthlyIncome){
    double amountSaved = monthlyIncome - monthlyExpenses;
    return amountSaved;
  }
  
  public static boolean validateCreditCard(long cardNumber){
    boolean b = true; 
    //b is true if credit card is valid
    long digit16 = cardNumber%10L;
    long digit15 = (cardNumber%100L)/10L;
    long digit14 = (cardNumber%1000L)/100L;
    long digit13 = (cardNumber%10000L)/1000L;
    long digit12 = (cardNumber%100000L)/10000L;
    long digit11 = (cardNumber%1000000L)/100000L;
    long digit10 = (cardNumber%10000000L)/1000000L;
    long digit9 = (cardNumber%100000000L)/10000000L;
    long digit8 = (cardNumber%1000000000L)/100000000L;
    long digit7 = (cardNumber%10000000000L)/1000000000L;
    long digit6 = (cardNumber%100000000000L)/10000000000L;
    long digit5 = (cardNumber%1000000000000L)/100000000000L;
    long digit4 = (cardNumber%10000000000000L)/1000000000000L;
    long digit3 = (cardNumber%100000000000000L)/10000000000000L;
    long digit2 = (cardNumber%1000000000000000L)/100000000000000L;
    long digit1 = (cardNumber%10000000000000000L)/1000000000000000L;
    //claculate sum of even digits in card munber
    long even = digit2+digit4+digit6+digit8+digit10+digit12+digit14+digit16;
    //calculate double odd digits then mod9 then calculate sum
    long odd = (digit1*2)%9+(digit3*2)%9+(digit5*2)%9+(digit7*2)%9+(digit9*2)%9+(digit11*2)%9+(digit13*2)%9+(digit15*2)%9;
    //if sum of even and odd digit calculation is a factor of 10 credit card is valid
    if((even+odd)%10 == 0){
        b = true;
    }
    //if sum of even and odd digit calculation is not a factor of 10 credit card is not valid
    else{
      b = false;
    }  
    return b;
  }

  //code to calculate expenses based on variable rent and if statements for months where extra expenses are made
  public static double[] buildExpenses(double monthlyRent){ 
    double[] month = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    for(int i=0; i<month.length; i++){
      if ((i==0)||(i==5)){
        month [i] = 600 + monthlyRent + 200;
      }
      else if (i==8){
        month [i] = 600 + monthlyRent + 300 +100;
      } 
      else if ((i==3)||(i==6)){
        month [i] = 600 + monthlyRent + 100;
      }
      else if (i==11){
        month [i] = 600 + monthlyRent + 200;
      }
      else{
        month [i]= 600 + monthlyRent;
      }
    }
    return month;
  }  

  //code to show how much money is being allocated towards credit card balance 
  //if statements to show months where additional payments are being made
  public static double [] buildPayments(double postTaxIncome){
    double [] monthlyPayment = {0, 1, 2, 3, 4, 5, 6, 7, 8 ,9, 10, 11};
    for(int i = 0; i<monthlyPayment.length; i++){
      if(i==8){
        monthlyPayment [i] = (postTaxIncome/12)*0.10 + 200;
      }
      else if(i==11){
        monthlyPayment [i] = (postTaxIncome/12)*0.10 + 150;
      }
      else{
        monthlyPayment [i] = (postTaxIncome/12)*0.10;
      }
    }
    return monthlyPayment;
  }

  //code to calculate credit card balance
  //if statetment to get rid of interest if balance is negative because the bank is not going to give you extra money cuz banks hate us
  public static void printBalance(double creditBalance, double interestRate, double [] monthlyExpenses, double [] monthlyPayments){
    double newBalance = 0.0;
    for(int i = 0; i<12; i++){
      if(creditBalance > 0){
        newBalance = (creditBalance + (monthlyExpenses[i]) - (monthlyPayments[i]))*(1+((interestRate/12)/100));
        System.out.println("Month " + (i+1) + " balance " + (newBalance));
        creditBalance = newBalance;
      }
      else{
        newBalance = (creditBalance + (monthlyExpenses[i]) - (monthlyPayments[i]));
        System.out.println("Month " + (i+1) + " balance " + (newBalance));
        creditBalance = newBalance;
      }
    } 
  }
  
}  