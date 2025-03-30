package storage;

import java.time.LocalDateTime;
import java.util.Objects;

public class Account {

    private final long accountId;
    private String accountName;
    private String email;
    private String loginId;
    private String password;
    private final LocalDateTime createdAt;

    public Account(String password, String loginId, String email, String accountName, long accountId) {
        this.createdAt = LocalDateTime.now();
        this.password = password;
        this.loginId = loginId;
        this.email = email;
        this.accountName = accountName;
        this.accountId = accountId;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Account account = (Account) object;
        return Objects.equals(email, account.email) && Objects.equals(loginId, account.loginId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, loginId);
    }
}
