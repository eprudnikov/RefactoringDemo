Currently I see following findings:
- Switch statement in Customer - it's smell because it could be a place of LSP violation.
- There are a couple of places where magic numbers are used: prices, threshold amount of days for extra price. When the system will grow, it could be a problem.
+ Customer looks like feature envy. All other classes do nothing. Customer does all.
+ Message chains in Customer. The same thing. 
-> move calculation logic into Rental class because it has almost all information that is necessary for calculation. Customer now is responsible only for formatting.