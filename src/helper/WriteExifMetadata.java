package helper;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.ImageWriteException;
import org.apache.commons.imaging.Imaging;

import org.apache.commons.imaging.common.IImageMetadata;
import org.apache.commons.imaging.formats.jpeg.JpegImageMetadata;
import org.apache.commons.imaging.formats.jpeg.exif.ExifRewriter;
import org.apache.commons.imaging.formats.jpeg.iptc.PhotoshopApp13Data;
import org.apache.commons.imaging.formats.tiff.TiffImageMetadata;
import org.apache.commons.imaging.formats.tiff.constants.*;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputDirectory;
import org.apache.commons.imaging.formats.tiff.write.TiffOutputSet;


public class WriteExifMetadata {


    public void WriteExif(File imageFile,String KeyWordsImage) throws ImageWriteException, ImageReadException, IOException {
        String imageString = imageFile.getName();
        String destFileString = FileHelper.getFilenameWithSuffix(imageString, "_TEMP");
        File destImageFile = new File(destFileString);
        changeExifMetadata(imageFile,destImageFile,KeyWordsImage);
    }


    /**
     * This example illustrates how to add/update EXIF metadata in a JPEG file.
     *
     * @param jpegImageFile
     *            A source image file.
     * @param dst
     *            The output file.
     * @param KeyWordsImage
     *                      String list mot clé de l'image
     * @throws IOException
     * @throws ImageReadException
     * @throws ImageWriteException
     */
    public void changeExifMetadata(final File jpegImageFile, final File dst,String KeyWordsImage) throws IOException, ImageReadException, ImageWriteException {
        OutputStream os = null;
        boolean canThrow = false;
        try {
            TiffOutputSet outputSet = null;

            // note that metadata might be null if no metadata is found.
            final IImageMetadata metadata = Imaging.getMetadata(jpegImageFile);
            final JpegImageMetadata jpegMetadata = (JpegImageMetadata) metadata;
            if (null != jpegMetadata) {
                // note that exif might be null if no Exif metadata is found.
                final TiffImageMetadata exif = jpegMetadata.getExif();

                if (null != exif) {
                    outputSet = exif.getOutputSet();
                }
            }
            if (null == outputSet) {
                outputSet = new TiffOutputSet();
            }
            // uniquement pour les metadata de type Exit
            //  final TiffOutputDirectory exifDirectory = outputSet.getOrCreateExifDirectory();
            // todo : faire pour les autre mot clé
            // uniquement pour les metadate de type Root
            TiffOutputDirectory exifDirectory = outputSet.findDirectory(TiffDirectoryConstants.DIRECTORY_TYPE_ROOT);
            // si il existe pas de type Root
            if (null == exifDirectory) {
                exifDirectory = outputSet.addRootDirectory();
            }
            // on supprime complement l'éttiquette XPkeywords et on reécrit dessus
            exifDirectory.removeField(AllTagConstants.EXIF_TAG_XPKEYWORDS);
//            exifDirectory.removeField(PhotoshopApp13Data.IPTC_RECORD_TAG_MARKER);

            //todo : si les mot clé vienent de photoshop de type IPTC on devrait remplire dedans et nons dans le Root
            exifDirectory.add(AllTagConstants.EXIF_TAG_XPKEYWORDS,KeyWordsImage);

            os = new FileOutputStream(dst);
            os = new BufferedOutputStream(os);

            new ExifRewriter().updateExifMetadataLossless(jpegImageFile, os,outputSet);
            jpegImageFile.delete();
            dst.renameTo(jpegImageFile);

            canThrow = true;
        } finally {
            if (os != null)
                try
                {
                    os.close();
                } catch (IOException e)
                {
                }
        }
    }
}
