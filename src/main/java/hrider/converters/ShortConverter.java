package hrider.converters;

import org.apache.hadoop.hbase.util.Bytes;

/**
 * Copyright (C) 2012 NICE Systems ltd.
 * <p/>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * @author Igor Cher
 * @version %I%, %G%
 *          <p/>
 *          This class is responsible for converting data from byte[] to short and vice versa.
 */
public class ShortConverter extends TypeConverter {

    private static final long serialVersionUID = -4063681955061981871L;

    @Override
    public String toString(byte[] value) {
        if (value == null) {
            return null;
        }
        return Short.toString(Bytes.toShort(value));
    }

    @Override
    public boolean canConvert(byte[] value) {
        try {
            Bytes.toShort(value);
            return true;
        }
        catch (Exception ignore) {
            return false;
        }
    }

    @Override
    public boolean supportsFormatting() {
        return false;
    }

    @Override
    public byte[] toBytes(String value) {
        if (value == null) {
            return EMPTY_BYTES_ARRAY;
        }
        return Bytes.toBytes(Short.parseShort(value));
    }
}
