package roomescape.fixture;

import roomescape.domain.Member;
import roomescape.domain.Sha256Encryptor;
import roomescape.dto.LoginRequest;
import roomescape.dto.MemberInfo;

import static roomescape.domain.Role.ADMIN;
import static roomescape.domain.Role.MEMBER;

public class MemberFixture {
    private static final Sha256Encryptor ENCRYPTOR = new Sha256Encryptor();

    public static final Member DEFAULT_MEMBER = asMember(1L, "member", "email@email.com", "qwer");

    public static final Member DEFAULT_ADMIN = asAdmin(2L, "admin", "email2@email.com", "qwer");

    public static final LoginRequest DEFAULT_MEMBER_LOGIN_REQUEST = new LoginRequest(
            DEFAULT_MEMBER.getEmail(),
            DEFAULT_MEMBER.getEncryptedPassword()
    );

    public static final MemberInfo DEFAULT_MEMBER_INFO = new MemberInfo(
            DEFAULT_MEMBER.getId(),
            DEFAULT_MEMBER.getName(),
            DEFAULT_MEMBER.getRole()
    );


    private static Member asAdmin(long id, String name, String email, String password) {
        return new Member(id, name, email, ENCRYPTOR.encrypt(password), ADMIN);
    }

    private static Member asMember(long id, String name, String email, String password) {
        return new Member(id, name, email, ENCRYPTOR.encrypt(password), MEMBER);
    }
}
