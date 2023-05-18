package cj.geochat.app.uc.remote;

import cj.geochat.middle.uc.UserDetails;
import cj.geochat.middle.uc.web.rest.IUserDetailsRestfull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "userDetailsRemote", value = "cj-geochat-middle-uc", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface UserDetailsRemote extends IUserDetailsRestfull {
    @RequestMapping(value = "/api/v1/user/details/loadUserDetails", method = RequestMethod.GET)
    @Override
    UserDetails loadUserDetails(@RequestParam String userId);
}
