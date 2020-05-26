package com.github.davio.starter.data.model;

import com.github.davio.starter.data.repository.EchoEntity;

import org.mapstruct.Mapper;

@Mapper
public interface EchoMapper {

    default EchoEntity toEntity(EchoMessage echoMessage) {
        EchoEntity echoEntity = new EchoEntity();
        echoEntity.setEchoMessage(echoMessage);
        return echoEntity;
    }

    default EchoMessage toMessage(EchoEntity echoEntity) {
        return echoEntity.getEchoMessage();
    }
}
