
package org.synyx.urlaubsverwaltung.core.account;

import org.joda.time.DateMidnight;

import org.synyx.urlaubsverwaltung.core.person.Person;

import java.math.BigDecimal;


/**
 * Provides services related to {@link Account} entities.
 *
 * @author  Aljona Murygina - murygina@synyx.de
 */
public interface AccountService {

    /**
     * Just saves the given {@link Account}.
     *
     * @param  account  to be saved
     */
    void save(Account account);


    /**
     * Gets the {@link Account} for the given year and person.
     *
     * @param  year  to get the holidays account for
     * @param  person  to get the holidays account for
     *
     * @return  {@link Account} that matches the given parameters
     */
    Account getHolidaysAccount(int year, Person person);


    /**
     * Creates a {@link Account} with the given parameters.
     *
     * @param  person  defines the owner of the holidays account
     * @param  validFrom  defines the start of the validity period, e.g. 1.1.2012
     * @param  validTo  defines the end of the validity period, e.g. 31.12.2012
     * @param  days  defines number of annual vacation days (the actual vacation days are calculated using the validity
     *               period)
     * @param  remainingDays  defines the number of remaining vacation days from the last year
     * @param  remainingDaysNotExpiring  defines the number of remaining vacation days that do not expire on 1st April
     *
     * @return  the created holidays account
     */
    Account createHolidaysAccount(Person person, DateMidnight validFrom, DateMidnight validTo, BigDecimal days,
        BigDecimal remainingDays, BigDecimal remainingDaysNotExpiring);


    /**
     * Edits the given {@link Account} with the given params.
     *
     * @param  account  to be edited
     * @param  validFrom  defines the start of the validity period, e.g. 1.1.2012
     * @param  validTo  defines the end of the validity period, e.g. 31.12.2012
     * @param  days  defines number of annual vacation days (the actual vacation days are calculated using the validity
     *               period)
     * @param  remainingDays  defines the number of remaining vacation days from the last year
     * @param  remainingDaysNotExpiring  defines the number of remaining vacation days that do not expire on 1st April
     *
     * @return  the updated holidays account
     */
    Account editHolidaysAccount(Account account, DateMidnight validFrom, DateMidnight validTo, BigDecimal days,
        BigDecimal remainingDays, BigDecimal remainingDaysNotExpiring);
}