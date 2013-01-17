package pl.grzejszczak.marcin.guava.cache.utils;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.String.format;

public final class RegexpUtils {

    private RegexpUtils() {
        throw new UnsupportedOperationException("RegexpUtils is a utility class - don't instantiate it!");
    }

    private static final LoadingCache<String, Pattern> COMPILED_PATTERNS =
            CacheBuilder.newBuilder().build(new CacheLoader<String, Pattern>() {
                @Override
                public Pattern load(String regexp) throws Exception {
                    return Pattern.compile(regexp);
                }
            });

    public static Pattern getPattern(String regexp) {
        try {
            return COMPILED_PATTERNS.get(regexp);
        } catch (ExecutionException e) {
            throw new RuntimeException(format("Error when getting a pattern [%s] from cache", regexp), e);
        }
    }

    public static boolean matches(String stringToCheck, String regexp) {
        return doGetMatcher(stringToCheck, regexp).matches();
    }

    public static Matcher getMatcher(String stringToCheck, String regexp) {
        return doGetMatcher(stringToCheck, regexp);
    }

    private static Matcher doGetMatcher(String stringToCheck, String regexp) {
        Pattern pattern = getPattern(regexp);
        return pattern.matcher(stringToCheck);
    }

}
