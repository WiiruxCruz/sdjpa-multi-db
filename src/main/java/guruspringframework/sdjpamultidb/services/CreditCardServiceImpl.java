package guruspringframework.sdjpamultidb.services;

import guruspringframework.sdjpamultidb.domain.cardholder.CreditCardHolder;
import guruspringframework.sdjpamultidb.domain.creditcard.CreditCard;
import guruspringframework.sdjpamultidb.domain.pan.CreditCardPAN;
import guruspringframework.sdjpamultidb.repositories.cardholder.CreditCardHolderRepository;
import guruspringframework.sdjpamultidb.repositories.creditcard.CreditCardRepository;
import guruspringframework.sdjpamultidb.repositories.pan.CreditCardPANRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreditCardServiceImpl implements CreditCardService {
	
	private final CreditCardHolderRepository cchr;
	private final CreditCardRepository ccr;
	private final CreditCardPANRepository ccpr;
	
	//public CreditCardServiceImpl
	
    @Override
    public CreditCard getCreditCardById(Long id) {
        //todo impl

        return null;
    }
    
    @Transactional
	@Override
	public CreditCard saveCreditCard(CreditCard cc) {
		// TODO Auto-generated method stub
    	CreditCard savedCC = ccr.save(cc);
    	
    	savedCC.setFirstName(cc.getFirstName());
    	savedCC.setLastName(cc.getLastName());
    	savedCC.setZipCode(cc.getZipCode());
    	savedCC.setCreditCardNumber(cc.getCreditCardNumber());
    	
    	cchr.save(
    		CreditCardHolder.builder()
    		.creditCardId(savedCC.getId())
    		.firstName(savedCC.getFirstName())
    		.lastName(savedCC.getLastName())
    		.zipCode(savedCC.getZipCode())
    		.build()
    	);
    	
    	ccpr.save(
    		CreditCardPAN.builder()
    		.creditCardNumber(savedCC.getCreditCardNumber())
    		.creditCardId(savedCC.getId())
    		.build()
    	);
    	
    	
		return savedCC;
	}
}
