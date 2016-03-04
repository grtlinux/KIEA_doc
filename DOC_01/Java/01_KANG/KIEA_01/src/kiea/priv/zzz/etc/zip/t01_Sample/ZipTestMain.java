package kiea.priv.zzz.etc.zip.t01_Sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipTestMain
{
	private static boolean flag = true;
	
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args)
	{
		if (flag) {
			/*
			 * ������ ������ �Ѱ��� ���Ϸ� �����Ѵ�.
			 */
			try {
				String[] inFiles = new String[] { "D:/zipfiles/a.txt", "D:/zipfiles/b.txt", "D:/other/c.txt" };
				String outZipFile = "D:/abc.zip";
				
				ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outZipFile));
				zos.setMethod(8);
				zos.setLevel(9);
				/*
				 * �ɼ�
				 * setMethod : 0(�������) 8(����)
				 * setLevel : -1(�⺻) 0~9(9�� ������ ����)
				 */
				
				for (String inFile : inFiles) {
					zos.putNextEntry(new ZipEntry(inFile));  // Ȯ�� �ʿ�
					
					FileInputStream fis = new FileInputStream(inFile);
					
					byte[] by = new byte[1024];
					while (true) {
						int len = fis.read(by, 0, by.length);
						if (len < 0)
							break;
						
						zos.write(by, 0, len);
					}
					
					fis.close();
					
					zos.closeEntry();
				}
				
				zos.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void test02(String[] args)
	{
		if (flag) {
			/*
			 * �Ѱ��� ���������� �������� �������Ϸ� Ǭ��.
			 */
			try {
				String inFile = "D:/abc.zip";
				String outFolder = "D:/unzip";
				
				ZipInputStream zis = new ZipInputStream(new FileInputStream(inFile));
				
				while (true) {
					ZipEntry zipEntry = zis.getNextEntry();
					if (zipEntry == null)
						break;
					
					FileOutputStream fos = new FileOutputStream(new File(outFolder, zipEntry.getName()));
					
					byte[] by = new byte[1024];
					while (true) {
						int len = zis.read(by, 0, by.length);
						if (len < 0)
							break;
						
						fos.write(by, 0, len);
					}
					
					fos.close();
					zis.closeEntry();
				}
				
				zis.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)
	{
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
