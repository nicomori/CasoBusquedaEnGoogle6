package com.smartfrog.modelclass;

/**
 * Class for management of test user update
 */
public class UserTestFlag {
    private final User user;

    public UserTestFlag(boolean isTestUser) {
        this.user = new User(isTestUser);
    }

    public User getUser() {
        return user;
    }

    private static final class User {

        private final boolean testAccount;

        private User(boolean testAccount) {
            this.testAccount = testAccount;
        }

        public boolean isTestAccount() {
            return testAccount;
        }
    }
}
