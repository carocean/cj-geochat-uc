package cj.geochat.middle.uc.surface;

import cj.geochat.ability.util.GeochatException;
import cj.geochat.middle.uc.AppDetails;

public interface IAppDetailsSurface {
    AppDetails loadAppByAppKey(String appKey) throws GeochatException;
}
