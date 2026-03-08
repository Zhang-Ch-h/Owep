package com.kclm.owep.convert;

import com.kclm.owep.dto.ClientDTO;
import com.kclm.owep.dto.ClientNoteDTO;
import com.kclm.owep.entity.Channel;
import com.kclm.owep.entity.ChannelType;
import com.kclm.owep.entity.Client;
import com.kclm.owep.entity.ClientNote;
import com.kclm.owep.entity.Profession;
import com.kclm.owep.entity.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-16T23:05:11+0800",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.6 (Oracle Corporation)"
)
public class ClientConvertImpl implements ClientConvert {

    @Override
    public ClientDTO entityToDTO(Client entity) {
        if ( entity == null ) {
            return null;
        }

        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setChannelTypeName( entityChannelChannelTypeChannelTypeName( entity ) );
        clientDTO.setUserName( entityUserUserName( entity ) );
        clientDTO.setProfession( entityProfessionProfName( entity ) );
        clientDTO.setChannelName( entityChannelChannelName( entity ) );
        clientDTO.setId( entity.getId() );
        clientDTO.setClientName( entity.getClientName() );
        clientDTO.setClientPhone( entity.getClientPhone() );
        clientDTO.setGender( entity.getGender() );
        clientDTO.setClientExperience( entity.getClientExperience() );
        clientDTO.setSalsemanDescribe( entity.getSalsemanDescribe() );
        clientDTO.setAdvancePay( entity.getAdvancePay() );
        clientDTO.setTotalPay( entity.getTotalPay() );
        clientDTO.setMonthPay( entity.getMonthPay() );
        clientDTO.setPayMent( entity.getPayMent() );
        clientDTO.setRepaymentPlan( entity.getRepaymentPlan() );
        clientDTO.setIsAssignClass( entity.getIsAssignClass() );
        clientDTO.setClientEmail( entity.getClientEmail() );
        clientDTO.setLoanStatus( entity.getLoanStatus() );
        clientDTO.setLoan( entity.getLoan() );
        clientDTO.setInterviewTimeStart( entity.getInterviewTimeStart() );
        clientDTO.setInterviewTimeEnd( entity.getInterviewTimeEnd() );
        clientDTO.setClientState( entity.getClientState() );
        clientDTO.setMajor( entity.getMajor() );
        clientDTO.setSignTime( entity.getSignTime() );
        clientDTO.setClientNoteList( clientNoteListToClientNoteDTOList( entity.getClientNoteList() ) );

        return clientDTO;
    }

    private String entityChannelChannelTypeChannelTypeName(Client client) {
        if ( client == null ) {
            return null;
        }
        Channel channel = client.getChannel();
        if ( channel == null ) {
            return null;
        }
        ChannelType channelType = channel.getChannelType();
        if ( channelType == null ) {
            return null;
        }
        String channelTypeName = channelType.getChannelTypeName();
        if ( channelTypeName == null ) {
            return null;
        }
        return channelTypeName;
    }

    private String entityUserUserName(Client client) {
        if ( client == null ) {
            return null;
        }
        User user = client.getUser();
        if ( user == null ) {
            return null;
        }
        String userName = user.getUserName();
        if ( userName == null ) {
            return null;
        }
        return userName;
    }

    private String entityProfessionProfName(Client client) {
        if ( client == null ) {
            return null;
        }
        Profession profession = client.getProfession();
        if ( profession == null ) {
            return null;
        }
        String profName = profession.getProfName();
        if ( profName == null ) {
            return null;
        }
        return profName;
    }

    private String entityChannelChannelName(Client client) {
        if ( client == null ) {
            return null;
        }
        Channel channel = client.getChannel();
        if ( channel == null ) {
            return null;
        }
        String channelName = channel.getChannelName();
        if ( channelName == null ) {
            return null;
        }
        return channelName;
    }

    protected ClientNoteDTO clientNoteToClientNoteDTO(ClientNote clientNote) {
        if ( clientNote == null ) {
            return null;
        }

        ClientNoteDTO clientNoteDTO = new ClientNoteDTO();

        clientNoteDTO.setId( clientNote.getId() );
        clientNoteDTO.setClientState( clientNote.getClientState() );
        clientNoteDTO.setCreateTime( clientNote.getCreateTime() );
        clientNoteDTO.setClientNote( clientNote.getClientNote() );

        return clientNoteDTO;
    }

    protected List<ClientNoteDTO> clientNoteListToClientNoteDTOList(List<ClientNote> list) {
        if ( list == null ) {
            return null;
        }

        List<ClientNoteDTO> list1 = new ArrayList<ClientNoteDTO>( list.size() );
        for ( ClientNote clientNote : list ) {
            list1.add( clientNoteToClientNoteDTO( clientNote ) );
        }

        return list1;
    }
}
