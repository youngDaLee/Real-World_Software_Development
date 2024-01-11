package org.dylee;

public class Main {
    public static void main(String[] args) {
        var evn = new Facts();
        BusinessRuleEngine businessRuleEngine = new BusinessRuleEngine(evn);

        businessRuleEngine.addAction(facts -> {
            var jobTitle = facts.getFact("jobTitle");
            if ("CEO".equals(jobTitle)) {
                var name = facts.getFact("name");
                Mailer.sendEmail("sales@company.com", "Relevant customer: " + name);
            }
        });
    }
}