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

public class LoginReq implements java.lang.Cloneable, java.io.Serializable
{
    public String username;

    public String password;

    public LoginReq()
    {
        username = "";
        password = "";
    }

    public LoginReq(String username, String password)
    {
        this.username = username;
        this.password = password;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        LoginReq _r = null;
        if(rhs instanceof LoginReq)
        {
            _r = (LoginReq)rhs;
        }

        if(_r != null)
        {
            if(username != _r.username)
            {
                if(username == null || _r.username == null || !username.equals(_r.username))
                {
                    return false;
                }
            }
            if(password != _r.password)
            {
                if(password == null || _r.password == null || !password.equals(_r.password))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::com::ksn::leo::rpc::ice::login::LoginReq");
        __h = IceInternal.HashUtil.hashAdd(__h, username);
        __h = IceInternal.HashUtil.hashAdd(__h, password);
        return __h;
    }

    public LoginReq
    clone()
    {
        LoginReq c = null;
        try
        {
            c = (LoginReq)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(username);
        __os.writeString(password);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        username = __is.readString();
        password = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, LoginReq __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public LoginReq
    __read(IceInternal.BasicStream __is, LoginReq __v)
    {
        if(__v == null)
        {
             __v = new LoginReq();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final LoginReq __nullMarshalValue = new LoginReq();

    public static final long serialVersionUID = 1132982868556468347L;
}