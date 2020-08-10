package com.example.user.afinal;
import java.util.BitSet;
import static com.example.user.afinal.BitSetHelpers.bitSetOf;
/**
 * Created by Lenovo on 12/14/2017.
 */

public class IPv6NetworkHelpers
{
    static int longestPrefixLength(IPv6Address first, IPv6Address last)
    {
        final BitSet firstBits = bitSetOf(first.getLowBits(), first.getHighBits());
        final BitSet lastBits = bitSetOf(last.getLowBits(), last.getHighBits());

        return countLeadingSimilarBits(firstBits, lastBits);
    }

    private static int countLeadingSimilarBits(BitSet a, BitSet b)
    {
        int result = 0;
        for (int i = 127; i >= 0 && (a.get(i) == b.get(i)); i--)
        {
            result++;
        }

        return result;
    }
}