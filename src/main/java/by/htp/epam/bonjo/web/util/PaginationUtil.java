package by.htp.epam.bonjo.web.util;

import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;

public class PaginationUtil implements Pageable{

	@Override
	public int getNumberOfPages() {
		return 0;
	}

	@Override
	public PageFormat getPageFormat(int arg0) throws IndexOutOfBoundsException {
		return null;
	}

	@Override
	public Printable getPrintable(int arg0) throws IndexOutOfBoundsException {
		return null;
	}

}
