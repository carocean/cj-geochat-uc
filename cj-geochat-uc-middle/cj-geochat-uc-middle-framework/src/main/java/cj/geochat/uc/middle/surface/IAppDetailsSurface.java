package cj.geochat.uc.middle.surface;

import cj.geochat.ability.util.GeochatException;
import cj.geochat.uc.middle.AppDetails;

public interface IAppDetailsSurface {
    AppDetails loadAppByAppKey(String appKey) throws GeochatException;
}
