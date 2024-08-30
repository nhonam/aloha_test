//package com.aloha.examtest.service;
//
//import com.devnhonam.nhonamtech.dto.request.PermissionRequest;
//import com.devnhonam.nhonamtech.dto.request.PermissionResponse;
//import com.devnhonam.nhonamtech.entity.Permission;
//import com.devnhonam.nhonamtech.mapper.PermissionMapper;
//import com.devnhonam.nhonamtech.repository.PermissionRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) // các field sẽ là private final
//@Slf4j
//public class QuizFiltersService {
//
//    PermissionRepository permissionRepository;
//    PermissionMapper permissionMapper;
//
//    public PermissionResponse create(PermissionRequest request) {
//
//        log.info(request.getName());
//        log.info(request.getDescription());
//        Permission permission = permissionMapper.toPermission(request);
//
//        permission = permissionRepository.save(permission);
//
//        return permissionMapper.toPermissionResponse(permission);
//    }
//
//    public List<PermissionResponse> getAll() {
//        var permissions = permissionRepository.findAll();
//
//        return permissions.stream().map(permissionMapper::toPermissionResponse).toList();
//    }
//
//    //    @PostAuthorize("returnObject.username == authentication.name") // phải đúng user đang đăng nhập thì mới có thể
//    // call method
//    //    public UserResponse getUser(String id) {
//    //        return userMapper.toUserResponse(userRepository.findById(id).orElseThrow(() -> new RuntimeException("User
//    // Not found")));
//    //    }
//
//    //    public UserResponse updateUser(String id, UserUpdateRequest request) {
//    //        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
//    //        userMapper.updateUser(user, request);
//    //        return userMapper.toUserResponse(userRepository.save(user));
//    //    }
//
//    public void delete(String permission) {
//        permissionRepository.deleteById(permission);
//    }
//}
