//package com.aloha.examtest.service;
//
//import com.devnhonam.nhonamtech.dto.request.AuthenticationRequest;
//import com.devnhonam.nhonamtech.dto.request.IntrospectRequest;
//import com.devnhonam.nhonamtech.dto.request.LogoutRequest;
//import com.devnhonam.nhonamtech.dto.request.RefresherTokenRequest;
//import com.devnhonam.nhonamtech.dto.response.AuthenticationResponse;
//import com.devnhonam.nhonamtech.dto.response.IntrospectResponse;
//import com.devnhonam.nhonamtech.entity.InvaltidatedToken;
//import com.devnhonam.nhonamtech.entity.User;
//import com.devnhonam.nhonamtech.exception.AppException;
//import com.devnhonam.nhonamtech.exception.ErrorCode;
//import com.devnhonam.nhonamtech.mapper.UserMapper;
//import com.devnhonam.nhonamtech.repository.InvalidatedTokenRepository;
//import com.devnhonam.nhonamtech.repository.UserRepository;
//import com.nimbusds.jose.*;
//import com.nimbusds.jose.crypto.MACSigner;
//import com.nimbusds.jose.crypto.MACVerifier;
//import com.nimbusds.jwt.JWTClaimsSet;
//import com.nimbusds.jwt.SignedJWT;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.experimental.NonFinal;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.util.CollectionUtils;
//
//import java.text.ParseException;
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//import java.util.StringJoiner;
//import java.util.UUID;
//
//@Service
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
//@RequiredArgsConstructor
//@Slf4j
//public class QuizFilterItemsService {
//
//
//
//    @NonFinal
//    @Value("${jwt.secretKey}")
//    protected String signerKey;
//
//    @NonFinal
//    @Value("${jwt.valid-duration}")
//    protected long validDuration;
//
//    @NonFinal
//    @Value("${jwt.refreshable-duration}")
//    protected long refreshableDuration;
//
//    //    #verifytoken
//    public IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException {
//        var token = request.getToken();
//        boolean isValid = true;
//
//        try {
//            verifyToken(token, false);
//        } catch (AppException e) {
//            isValid = false;
//        }
//        return IntrospectResponse.builder().valid(isValid).build();
//    }
//
//    public AuthenticationResponse authenticate(AuthenticationRequest request) throws JOSEException {
//
//        log.info("signerKey: {}", signerKey);
//
//        var user = userRepository
//                .findByUsername(request.getUsername())
//                .orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXSITED));
//
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
//        boolean isAuthen = passwordEncoder.matches(request.getPassword(), user.getPassword());
//        if (!isAuthen) {
//            throw new AppException(ErrorCode.UNAUTHENTICATED);
//        }
//
//        var token = generateToken(user);
//
//        return AuthenticationResponse.builder()
//                .token(token)
//                .userResponse(userMapper.toUserResponse(user))
//                .isAuthenticated(true)
//                .build();
//    }
//
//    public void logout(LogoutRequest request) throws ParseException, JOSEException {
//
//        try {
//            var signToken = verifyToken(request.getToken(), true);
//
//            String jit = signToken.getJWTClaimsSet().getJWTID();
//            Date expiryTime = signToken.getJWTClaimsSet().getExpirationTime();
//
//            InvaltidatedToken invaltidatedToken =
//                    InvaltidatedToken.builder().id(jit).expiryTime(expiryTime).build();
//            invalidatedTokenRepository.save(invaltidatedToken);
//        } catch (AppException e) {
//            log.info("Token already expired !!! ");
//        }
//    }
//
//    private SignedJWT verifyToken(String token, boolean isRefresh) throws JOSEException, ParseException {
//        JWSVerifier verifier = new MACVerifier(signerKey.getBytes());
//
//        SignedJWT signedJWT = SignedJWT.parse(token);
//
//        Date expityTime = (isRefresh)
//                ? new Date(signedJWT
//                        .getJWTClaimsSet()
//                        .getIssueTime()
//                        .toInstant()
//                        .plus(refreshableDuration, ChronoUnit.SECONDS)
//                        .toEpochMilli())
//                : signedJWT.getJWTClaimsSet().getExpirationTime();
//
//        var verfied = signedJWT.verify(verifier);
//
//        if (!(verfied && expityTime.after(new Date()))) throw new AppException(ErrorCode.UNAUTHORIZED);
//
//        if (invalidatedTokenRepository.existsById(signedJWT.getJWTClaimsSet().getJWTID()))
//            throw new AppException(ErrorCode.UNAUTHENTICATED);
//        return signedJWT;
//    }
//
//    public AuthenticationResponse refreshToken(RefresherTokenRequest request) throws ParseException, JOSEException {
//
//        // kieerm tra lại hiệu lực token
//        var signJWT = verifyToken(request.getToken(), true);
//
//        // và logout token hiện tại
//        var jit = signJWT.getJWTClaimsSet().getJWTID();
//        var expiryTime = signJWT.getJWTClaimsSet().getExpirationTime();
//        InvaltidatedToken invaltidatedToken =
//                InvaltidatedToken.builder().id(jit).expiryTime(expiryTime).build();
//        invalidatedTokenRepository.save(invaltidatedToken);
//
//        var username = signJWT.getJWTClaimsSet().getSubject();
//
//        var user =
//                userRepository.findByUsername(username).orElseThrow(() -> new AppException(ErrorCode.UNAUTHENTICATED));
//
//        var token = generateToken(user);
//
//        return AuthenticationResponse.builder()
//                .token(token)
//                .isAuthenticated(true)
//                .build();
//    }
//
//    private String generateToken(User user) throws JOSEException {
//
//        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
//
//        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
//                .subject(user.getUsername())
//                .issuer("nhonam.tech.com")
//                .issueTime(new Date())
//                .expirationTime(new Date(
//                        Instant.now().plus(validDuration, ChronoUnit.SECONDS).toEpochMilli() // hết hạn sau 1 giờ
//                        ))
//                .jwtID(UUID.randomUUID().toString())
//                .claim("scope", buildScope(user))
//                .build();
//
//        Payload payload = new Payload(jwtClaimsSet.toJSONObject());
//
//        JWSObject jwsObject = new JWSObject(header, payload);
//        try {
//            jwsObject.sign(new MACSigner(signerKey.getBytes()));
//            return jwsObject.serialize();
//        } catch (JOSEException e) {
//            log.error("không thể tạo token " + e.getMessage());
//            throw new JOSEException(e);
//        }
//    }
//
//    private String buildScope(User user) {
//        StringJoiner stringJoiner = new StringJoiner(" ");
//        if (!CollectionUtils.isEmpty(user.getRoles())) {
//            user.getRoles().forEach(role -> {
//                stringJoiner.add("ROLE_" + role.getName());
//                if (!CollectionUtils.isEmpty(role.getPermissions()))
//                    role.getPermissions().forEach(permission -> stringJoiner.add(permission.getName()));
//            });
//        }
//        return stringJoiner.toString();
//    }
//}
