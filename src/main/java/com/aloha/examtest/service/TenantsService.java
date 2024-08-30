//package com.aloha.examtest.service;
//
//import com.devnhonam.nhonamtech.dto.request.RoleRequest;
//import com.devnhonam.nhonamtech.dto.request.RoleResponse;
//import com.devnhonam.nhonamtech.entity.Role;
//import com.devnhonam.nhonamtech.mapper.RoleMapper;
//import com.devnhonam.nhonamtech.repository.PermissionRepository;
//import com.devnhonam.nhonamtech.repository.RoleRepository;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.List;
//
//@Service
//@RequiredArgsConstructor
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true) // các field sẽ là private final
//@Slf4j
//public class TenantsService {
//
//    RoleRepository roleRepository;
//    PermissionRepository permissionRepository;
//    RoleMapper roleMapper;
//
//    public RoleResponse create(RoleRequest request) {
//        Role role = roleMapper.toRole(request);
//        var permissions = permissionRepository.findAllById(request.getPermissions());
//        role.setPermissions(new HashSet<>(permissions));
//        role = roleRepository.save(role);
//
//        return roleMapper.toRoleResponse(role);
//    }
//
//    public List<RoleResponse> getAll() {
//
//        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
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
//    public void delete(String role) {
//        roleRepository.deleteById(role);
//    }
//}
