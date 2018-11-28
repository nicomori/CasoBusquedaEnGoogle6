@User @PartnerPassword @Smoke @Partner @Maxenergy @jira=QA-3273 @Desktop
Feature: Maxenergy - User acquisition

Scenario Outline: Generate a new user in the partner.
	Given create a csv file to make the upload to partners
	And partnerRef should be "<partnerRef>" and authorization "<authoricationCode>"
	Then upload the file for the partners
	And wait now 5min and check the mailbox and click on the link in the mail
	Then verify if you are on the password page in smartfrog
	
	Examples:
      | partnerRef	 | authoricationCode				 |
      | MAXENERGY	 | Basic Z2VuaWU6Z2VuaWU6MDE=	 |


