package br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.impl;

import br.com.guilhermeevangelista.selenium.core.utils.report.screenshot.exceptions.ScreenshotException;
import com.google.common.base.Function;


public class RunScreenshot {

	public <V, T> V take(Function<? super T, V> isTrue) {
		try {
			return isTrue.apply(null);
		} catch (Exception e) {
			throw new ScreenshotException(e);
		}
	}
}
