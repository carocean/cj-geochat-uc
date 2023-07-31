package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.util.GeochatException;
import cj.geochat.uc.middle.AppDetails;

public interface IAppDetailsRestfull {
    AppDetails loadAppByAppKey(String appKey) throws GeochatException;
}
