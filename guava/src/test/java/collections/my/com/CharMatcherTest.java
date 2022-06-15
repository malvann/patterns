package collections.my.com;

import com.google.common.base.CharMatcher;
import com.google.common.base.Predicate;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CharMatcherTest {
    @Test
    public void whenRemoveNonASCIIChars_thenRemoved() {
        String input = "あhello₤";
        CharMatcher matcher = CharMatcher.ascii();
        String result = matcher.retainFrom(input);

        assertEquals("hello", result);
    }

    @Test
    public void whenRemoveCharsNotInCharset_thenRemoved() {
        Charset charset = Charset.forName("cp437");
        CharsetEncoder encoder = charset.newEncoder();

        Predicate<Character> inRange = encoder::canEncode;

        String result = CharMatcher.forPredicate(inRange)
                .retainFrom("helloは");
        assertEquals("hello", result);
    }

    @Test
    public void whenValidateString_thenValid() {
        String input = "hello";

        boolean result = CharMatcher.javaLowerCase().matchesAllOf(input);
        assertTrue(result);

        result = CharMatcher.is('e').matchesAnyOf(input);
        assertTrue(result);

        result = CharMatcher.javaDigit().matchesNoneOf(input);
        assertTrue(result);
    }

    @Test
    public void whenTrimString_thenTrimmed() {
        String input = "---hello,,,";

        String result = CharMatcher.is('-').trimLeadingFrom(input);
        assertEquals("hello,,,", result);

        result = CharMatcher.is(',').trimTrailingFrom(input);
        assertEquals("---hello", result);

        result = CharMatcher.anyOf("-,").trimFrom(input);
        assertEquals("hello", result);
    }

    @Test
    public void whenCollapseFromString_thenCollapsed() {
        String input = "       hel    lo      ";

        String result = CharMatcher.is(' ').collapseFrom(input, '-');
        assertEquals("-hel-lo-", result);

        result = CharMatcher.is(' ').trimAndCollapseFrom(input, '-');
        assertEquals("hel-lo", result);
    }

    @Test
    public void whenReplaceFromString_thenReplaced() {
        String input = "apple-banana.";

        String result = CharMatcher.anyOf("-.").replaceFrom(input, '!');
        assertEquals("apple!banana!", result);

        result = CharMatcher.is('-').replaceFrom(input, " and ");
        assertEquals("apple and banana.", result);
    }

    @Test
    public void whenCountCharInString_thenCorrect() {
        String input = "a, c, z, 1, 2";

        int result = CharMatcher.is(',').countIn(input);
        assertEquals(4, result);

        result = CharMatcher.inRange('a', 'h').countIn(input);
        assertEquals(2, result);
    }
}
