package cj.geochat.middle.uc.web;

import cj.geochat.ability.util.GeochatException;
import cj.geochat.middle.uc.AppDetails;

public interface IAppDetailsRestfull {
    AppDetails loadAppByAppKey(String appKey) throws GeochatException;
}
