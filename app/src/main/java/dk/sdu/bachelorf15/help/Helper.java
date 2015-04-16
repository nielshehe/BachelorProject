package dk.sdu.bachelorf15.help;

import android.widget.ImageView;

/**
 * Created by Mette on 15/04/15.
 */
public class Helper
{
    // Method to get the image from an ImageView
    public int getImageId(ImageView view)
    {
        return (Integer) view.getTag();
    }

    public void setImageAndTag(ImageView image, int imageId)
    {
        image.setImageResource(imageId);
        image.setTag(imageId);
    }
}
