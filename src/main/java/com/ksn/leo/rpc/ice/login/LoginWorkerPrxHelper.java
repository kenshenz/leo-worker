// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.2
//
// <auto-generated>
//
// Generated from file `Login.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.ksn.leo.rpc.ice.login;

/**
 * Provides type-specific helper functions.
 **/
public final class LoginWorkerPrxHelper extends Ice.ObjectPrxHelperBase implements LoginWorkerPrx
{
    private static final String __login_name = "login";

    public LoginResp login(LoginReq req)
    {
        return login(req, null, false);
    }

    public LoginResp login(LoginReq req, java.util.Map<String, String> __ctx)
    {
        return login(req, __ctx, true);
    }

    private LoginResp login(LoginReq req, java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        __checkTwowayOnly(__login_name);
        return end_login(begin_login(req, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_login(LoginReq req)
    {
        return begin_login(req, null, false, false, null);
    }

    public Ice.AsyncResult begin_login(LoginReq req, java.util.Map<String, String> __ctx)
    {
        return begin_login(req, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_login(LoginReq req, Ice.Callback __cb)
    {
        return begin_login(req, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_login(LoginReq req, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_login(req, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_login(LoginReq req, Callback_LoginWorker_login __cb)
    {
        return begin_login(req, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_login(LoginReq req, java.util.Map<String, String> __ctx, Callback_LoginWorker_login __cb)
    {
        return begin_login(req, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_login(LoginReq req, 
                                       IceInternal.Functional_GenericCallback1<LoginResp> __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_login(req, null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_login(LoginReq req, 
                                       IceInternal.Functional_GenericCallback1<LoginResp> __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_login(req, null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_login(LoginReq req, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_GenericCallback1<LoginResp> __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_login(req, __ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_login(LoginReq req, 
                                       java.util.Map<String, String> __ctx, 
                                       IceInternal.Functional_GenericCallback1<LoginResp> __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_login(req, __ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_login(LoginReq req, 
                                        java.util.Map<String, String> __ctx, 
                                        boolean __explicitCtx, 
                                        boolean __synchronous, 
                                        IceInternal.Functional_GenericCallback1<LoginResp> __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_login(req, __ctx, __explicitCtx, __synchronous, 
                           new IceInternal.Functional_TwowayCallbackArg1<com.ksn.leo.rpc.ice.login.LoginResp>(__responseCb, __exceptionCb, __sentCb)
                               {
                                   public final void __completed(Ice.AsyncResult __result)
                                   {
                                       LoginWorkerPrxHelper.__login_completed(this, __result);
                                   }
                               });
    }

    private Ice.AsyncResult begin_login(LoginReq req, 
                                        java.util.Map<String, String> __ctx, 
                                        boolean __explicitCtx, 
                                        boolean __synchronous, 
                                        IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__login_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__login_name, __cb);
        try
        {
            __result.prepare(__login_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            LoginReq.__write(__os, req);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public LoginResp end_login(Ice.AsyncResult __iresult)
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __login_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            LoginResp __ret = null;
            __ret = LoginResp.__read(__is, __ret);
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __login_completed(Ice.TwowayCallbackArg1<LoginResp> __cb, Ice.AsyncResult __result)
    {
        com.ksn.leo.rpc.ice.login.LoginWorkerPrx __proxy = (com.ksn.leo.rpc.ice.login.LoginWorkerPrx)__result.getProxy();
        LoginResp __ret = null;
        try
        {
            __ret = __proxy.end_login(__result);
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static LoginWorkerPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static LoginWorkerPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static LoginWorkerPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static LoginWorkerPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static LoginWorkerPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static LoginWorkerPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, LoginWorkerPrx.class, LoginWorkerPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::com::ksn::leo::rpc::ice::login::LoginWorker"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, LoginWorkerPrx v)
    {
        __os.writeProxy(v);
    }

    public static LoginWorkerPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            LoginWorkerPrxHelper result = new LoginWorkerPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
