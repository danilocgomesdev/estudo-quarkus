package fieg.core.util;

import org.jboss.resteasy.util.DateUtil;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


public class DateUtils {
	public static DateFormat BRAZIL_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
	public static DateFormat BRAZIL_SHORT_FORMAT = new SimpleDateFormat("dd/MM/yy");

	/**
	 * Não é possivel instanciar DateUtils.
	 */
	private DateUtils() {
	}

	/**
	 * Retorna o valor do horário minimo para a data de referencia passada.
	 * <BR>
	 * <BR> Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
	 * retornada por este metodo será "30/01/2009 as 00h:00m:00s e 000ms".
	 *
	 * @param date de referencia.
	 * @return {@link Date} que representa o horário minimo para dia informado.
	 */
	public static Date lowDateTime(Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);
		toOnlyDate(aux); //zera os parametros de hour,min,sec,milisec
		return aux.getTime();
	}

	/**
	 * Retorna o valor do horário maximo para a data de referencia passada.
	 * <BR>
	 * <BR> Por exemplo se a data for "30/01/2009 as 17h:33m:12s e 299ms" a data
	 * retornada por este metodo será "30/01/2009 as 23h:59m:59s e 999ms".
	 *
	 * @param date de referencia.
	 * @return {@link Date} que representa o horário maximo para dia informado.
	 */
	public static Date highDateTime(Date date) {
		Calendar aux = Calendar.getInstance();
		aux.setTime(date);
		toOnlyDate(aux); //zera os parametros de hour,min,sec,milisec
		aux.roll(Calendar.DATE, true); //vai para o dia seguinte
		aux.roll(Calendar.MILLISECOND, false); //reduz 1 milisegundo
		return aux.getTime();
	}

	/**
	 * Zera todas as referencias de hora, minuto, segundo e milesegundo do
	 * {@link Calendar}.
	 *
	 * @param date a ser modificado.
	 */
	public static void toOnlyDate(Calendar date) {
		date.set(Calendar.HOUR_OF_DAY, 0);
		date.set(Calendar.MINUTE, 0);
		date.set(Calendar.SECOND, 0);
		date.set(Calendar.MILLISECOND, 0);
	}

	/**
	 * Converte uma {@link String} no formato "dd/mm/yyyy" ou "dd/mm/yy" em um
	 * {@link Date}.
	 *
	 * @param date a {@link String} contendo a data.
	 * @return o objeto {@link Date} para a string passada.
	 * @throws IllegalArgumentException caso a string não seja em dos dois
	 *                                  formatos permitidos.
	 */

	public static Date toDate(String date) throws ParseException {
		if (date == null) return null;

		return date.length() > 8 ? BRAZIL_FORMAT.parse(date) : BRAZIL_SHORT_FORMAT.parse(date);
	}

	/**
	 * Formata a data passada em uma {@link String} com o formato "dd/mm/yyyy".
	 *
	 * @param date a data a ser formatada.
	 * @return {@link String} com a data formatada.
	 */
	public static String toString(Date date) {
		if (date == null) return null;

		return BRAZIL_FORMAT.format(date);
	}

	/**
	 * Formata a data passada em uma {@link String} com <tt>shortFormat</tt>
	 * "dd/mm/yy", ou com o formato longo "dd/mm/yyyy".
	 *
	 * @param date        a data a ser formatada.
	 * @param shortFormat <tt>true</tt> se o formato � o curto, ou
	 *                    <tt>false</tt> caso o formato seja o longo.
	 * @return {@link String} com a data formatada.
	 */
	public static String toString(Date date, boolean shortFormat) {
		if (date == null) return null;

		return shortFormat ? BRAZIL_SHORT_FORMAT.format(date) : BRAZIL_FORMAT.format(date);
	}

	/**
	 * Retorna mês como texto levando em consideraçao o local PT BR.
	 */
	public static String retornaMes(Integer mes) {
		if (mes == null) return null;

		mes = mes - 1; //o m�s de Janeiro � 0
		Locale meuLocal = new Locale("pt", "BR");
		Calendar hoje = Calendar.getInstance();
		hoje.set(Calendar.MONTH, mes);
		DateFormatSymbols dfs = new DateFormatSymbols(meuLocal);
		String[] meses = dfs.getMonths();
		return meses[mes];
	}

	/**
	 * Retorna dia por extenso.
	 *
	 * @return Retorna dia por extenso.
	 */
	public static String diaPorExtenso(Date date) {

		Locale meuLocal = new Locale("pt", "BR");
		Calendar hoje = Calendar.getInstance();
		hoje.setTime(date);
		DateFormatSymbols dfs = new DateFormatSymbols(meuLocal);
		int diaSemana = hoje.get(Calendar.DAY_OF_WEEK);
		int mes = hoje.get(Calendar.MONTH);
		int diaMes = hoje.get(Calendar.DAY_OF_MONTH);
		int ano = hoje.get(Calendar.YEAR);
		String[] diasDaSemana = dfs.getWeekdays();
		String[] meses = dfs.getMonths();
		return (" " + diasDaSemana[diaSemana] + ", " + diaMes + " de " + meses[mes] + " de " + ano);
	}

	/**
	 * Formata data com util.
	 *
	 * @return data formatada pelo util.
	 */
	public static String formatDateRest(Date date) {
		if (date == null) return null;

		return DateUtil.formatDate(date);
	}

	/**
	 * Faz parse de string para date.
	 */
	public static Date parseDateRest(String dateFormatted) {
		if (dateFormatted == null) return null;

		return DateUtil.parseDate(dateFormatted);
	}

	/**
	 * Converte data para Calendar sem dados de horário.
	 *
	 * @param date data a ser convertida.
	 * @return calendar apos conversao.
	 */
	public static Calendar calendarSemTime(Date date) {
		if (date == null) return null;

		Calendar instance = Calendar.getInstance();
		instance.setTime(date);
		instance.set(Calendar.MINUTE, 0);
		instance.set(Calendar.HOUR, 0);
		instance.set(Calendar.SECOND, 0);
		instance.set(Calendar.MILLISECOND, 0);

		return instance;
	}
}
