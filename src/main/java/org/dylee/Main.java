package org.dylee;

public class Main {
    public static void main(String[] args) {
        var evn = new Facts();
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(evn);

//        businessRuleEngine.addAction(facts -> {
//            var jobTitle = facts.getFact("jobTitle");
//            if ("CEO".equals(jobTitle)) {
//                var name = facts.getFact("name");
//                Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
//            }
//        });

        businessRuleEngine.addAction(facts -> {
            var forecastedAmount = 0.0;
            var dealStage = Stage.valueOf(facts.getFact("stage"));
            var amount = Double.parseDouble(facts.getFact("amount"));
            switch (dealStage) {
                case LEAD:
                    forecastedAmount = amount * 0.2;
                    break;
                case EVALUATING:
                    forecastedAmount = amount * 0.5;
                    break;
                case INTERESTED:
                    forecastedAmount = amount * 0.8;
                    break;
                case CLOSED:
                    forecastedAmount = amount;
                    break;

            }
        });
    }
}