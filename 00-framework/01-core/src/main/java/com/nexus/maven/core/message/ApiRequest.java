package com.nexus.maven.core.message;

import com.google.protobuf.Internal;
import com.nexus.maven.core.AppVersion;

/**
 * Created by @panyao on 2017/8/25.
 */
public class ApiRequest implements AppVersion {

    private final Internal.EnumLite apiPathCode;
    private final Internal.EnumLite apiOpcode;
    private final String version;
    private final RequestArg[] args;

    private ApiRequest(Internal.EnumLite apiPathCode, Internal.EnumLite apiOpcode, String version, RequestArg[] args) {
        this.apiPathCode = apiPathCode;
        this.apiOpcode = apiOpcode;
        this.version = version;
        this.args = args;
    }

    public static ApiRequest newApiRequest(Internal.EnumLite apiPathCode, Internal.EnumLite apiMethod, String version, RequestArg[] args) {
        return new ApiRequest(apiPathCode, apiMethod, version, args);
    }

    public Internal.EnumLite getApiPathCode() {
        return this.apiPathCode;
    }

    public Internal.EnumLite getApiOpcode() {
        return apiOpcode;
    }

    public String getVersion() {
        return this.version;
    }

    public RequestArg[] getArgs() {
        return this.args;
    }

    public RequestArg getArg(int argName) {
        if (args == null || args.length == 0) {
            return null;
        }

        try {
            return args[argName];
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public RequestArg[] subArg(int subSize) {
        if (args == null || args.length < 2) {
            return null;
        }
        RequestArg[] args = new RequestArg[this.getArgs().length - subSize];
        for (int i = subSize; i < this.getArgs().length; i++) {
            args[i - subSize] = this.getArgs()[i];
        }
        return args;
    }

}
