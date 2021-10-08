package fieg.core.util;

import java.text.Normalizer;

public final class StringUtils {

	/**
	 * Remove caractes especiais do texto. Usa a regex: [^\w|\-.].
	 *
	 * @param texto texto a ser tratado.
	 * @return texto tratado ou null em caso de texto null.
	 */
	public static String removaCaracteresEspeciais(String texto) {
		if (texto == null) return texto;

		return Normalizer
				.normalize(texto, Normalizer.Form.NFD)
				.replaceAll("[^\\w|\\-.]", "");
	}
}
