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
            var dealStage = Stage.valueOf(facts.getFact("stage"));
            var amount = Double.parseDouble(facts.getFact("amount"));
            var forecastedAmount = amount * switch (dealStage) {
                case LEAD -> 0.2;
                case EVALUATING -> 0.5;
                case INTERESTED -> 0.8;
                case CLOSED -> 1;
            };
            facts.addFact("forecastedAmount", String.valueOf(forecastedAmount));
        });
    }
}