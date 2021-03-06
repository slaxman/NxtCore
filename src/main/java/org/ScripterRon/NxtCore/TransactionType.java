/*
 * Copyright 2014-2015 Ronald Hoffman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.ScripterRon.NxtCore;

/**
 * Transaction types
 */
public abstract class TransactionType {

    /** Payment transaction */
    public static final byte TYPE_PAYMENT = 0;
    /** Send ordinary payment */
    public static final byte SUBTYPE_PAYMENT_ORDINARY_PAYMENT = 0;

    /** Messaging transaction */
    public static final byte TYPE_MESSAGING = 1;
    /** Send arbitrary message */
    public static final byte SUBTYPE_MESSAGING_ARBITRARY_MESSAGE = 0;
    /** Assign alias */
    public static final byte SUBTYPE_MESSAGING_ALIAS_ASSIGNMENT = 1;
    /** Create poll */
    public static final byte SUBTYPE_MESSAGING_POLL_CREATION = 2;
    /** Cast vote */
    public static final byte SUBTYPE_MESSAGING_VOTE_CASTING = 3;
    /** Announce hub */
    public static final byte SUBTYPE_MESSAGING_HUB_ANNOUNCEMENT = 4;
    /** Set account information */
    public static final byte SUBTYPE_MESSAGING_ACCOUNT_INFO = 5;
    /** Sell alias */
    public static final byte SUBTYPE_MESSAGING_ALIAS_SELL = 6;
    /** Buy alias */
    public static final byte SUBTYPE_MESSAGING_ALIAS_BUY = 7;
    /** Delete alias */
    public static final byte SUBTYPE_MESSAGING_ALIAS_DELETE = 8;
    /** Phasing vote casting */
    public static final byte SUBTYPE_MESSAGING_PHASING_VOTE_CASTING = 9;

    /** Colored coin transaction (Asset Exchange) */
    public static final byte TYPE_COLORED_COINS = 2;
    /** Issue asset*/
    public static final byte SUBTYPE_COLORED_COINS_ASSET_ISSUANCE = 0;
    /** Transfer asset */
    public static final byte SUBTYPE_COLORED_COINS_ASSET_TRANSFER = 1;
    /** Place ask order */
    public static final byte SUBTYPE_COLORED_COINS_ASK_ORDER_PLACEMENT = 2;
    /** Place bid order */
    public static final byte SUBTYPE_COLORED_COINS_BID_ORDER_PLACEMENT = 3;
    /** Cancel ask order */
    public static final byte SUBTYPE_COLORED_COINS_ASK_ORDER_CANCELLATION = 4;
    /** Cancel bid order */
    public static final byte SUBTYPE_COLORED_COINS_BID_ORDER_CANCELLATION = 5;
    /** Dividend payment */
    public static final byte SUBTYPE_COLORED_COINS_DIVIDEND_PAYMENT = 6;

    /** Digital goods transaction */
    public static final byte TYPE_DIGITAL_GOODS = 3;
    /** List digital goods */
    public static final byte SUBTYPE_DIGITAL_GOODS_LISTING = 0;
    /** Delist digital goods */
    public static final byte SUBTYPE_DIGITAL_GOODS_DELISTING = 1;
    /** Change digital goods price */
    public static final byte SUBTYPE_DIGITAL_GOODS_PRICE_CHANGE = 2;
    /** Change digital good quantity */
    public static final byte SUBTYPE_DIGITAL_GOODS_QUANTITY_CHANGE = 3;
    /** Purchase digital goods */
    public static final byte SUBTYPE_DIGITAL_GOODS_PURCHASE = 4;
    /** Digital goods delivery */
    public static final byte SUBTYPE_DIGITAL_GOODS_DELIVERY = 5;
    /** Digital goods feedback */
    public static final byte SUBTYPE_DIGITAL_GOODS_FEEDBACK = 6;
    /** Digital goods refund */
    public static final byte SUBTYPE_DIGITAL_GOODS_REFUND = 7;

    /** Account control transaction */
    public static final byte TYPE_ACCOUNT_CONTROL = 4;
    /** Lease effective balance */
    public static final byte SUBTYPE_ACCOUNT_CONTROL_EFFECTIVE_BALANCE_LEASING = 0;

    /** Monetary system transaction */
    public static final byte TYPE_MONETARY_SYSTEM = 5;
    /** Issue currency */
    public static final byte SUBTYPE_MONETARY_SYSTEM_CURRENCY_ISSUANCE = 0;
    /** Increase reserve */
    public static final byte SUBTYPE_MONETARY_SYSTEM_RESERVE_INCREASE = 1;
    /** Claim reserve */
    public static final byte SUBTYPE_MONETARY_SYSTEM_RESERVE_CLAIM = 2;
    /** Transfer currency */
    public static final byte SUBTYPE_MONETARY_SYSTEM_CURRENCY_TRANSFER = 3;
    /** Publish exchange offer */
    public static final byte SUBTYPE_MONETARY_SYSTEM_PUBLISH_EXCHANGE_OFFER = 4;
    /** Exchange buy */
    public static final byte SUBTYPE_MONETARY_SYSTEM_EXCHANGE_BUY = 5;
    /** Exchange sell */
    public static final byte SUBTYPE_MONETARY_SYSTEM_EXCHANGE_SELL = 6;
    /** Mint currency */
    public static final byte SUBTYPE_MONETARY_SYSTEM_CURRENCY_MINTING = 7;
    /** Delete currency */
    public static final byte SUBTYPE_MONETARY_SYSTEM_CURRENCY_DELETION = 8;

    /** Data transaction */
    public static final byte TYPE_DATA = 6;
    /** Upload tagged data */
    public static final byte SUBTYPE_DATA_TAGGED_DATA_UPLOAD = 0;
    /** Extend tagged data */
    public static final byte SUBTYPE_DATA_TAGGED_DATA_EXTEND = 1;

    /**
     * Return the TransactionType for the specified type and subtype values
     *
     * @param       type                    Transaction type
     * @param       subtype                 Transaction subtype
     * @return                              TransactionType or null if invalid type/subtype
     */
    public static final TransactionType findTransactionType(byte type, byte subtype) {
        TransactionType txType = null;
        switch (type) {
            case TYPE_PAYMENT:
                switch (subtype) {
                    case SUBTYPE_PAYMENT_ORDINARY_PAYMENT:
                        txType = Payment.ORDINARY;
                        break;
                }
                break;
            case TYPE_MESSAGING:
                switch (subtype) {
                    case SUBTYPE_MESSAGING_ARBITRARY_MESSAGE:
                        txType = Messaging.ARBITRARY_MESSAGE;
                        break;
                    case SUBTYPE_MESSAGING_ALIAS_ASSIGNMENT:
                        txType = Messaging.ALIAS_ASSIGNMENT;
                        break;
                    case SUBTYPE_MESSAGING_POLL_CREATION:
                        txType = Messaging.POLL_CREATION;
                        break;
                    case SUBTYPE_MESSAGING_VOTE_CASTING:
                        txType = Messaging.VOTE_CASTING;
                        break;
                    case SUBTYPE_MESSAGING_HUB_ANNOUNCEMENT:
                        txType = Messaging.HUB_ANNOUNCEMENT;
                        break;
                    case SUBTYPE_MESSAGING_ACCOUNT_INFO:
                        txType = Messaging.ACCOUNT_INFO;
                        break;
                    case SUBTYPE_MESSAGING_ALIAS_SELL:
                        txType = Messaging.ALIAS_SELL;
                        break;
                    case SUBTYPE_MESSAGING_ALIAS_BUY:
                        txType = Messaging.ALIAS_BUY;
                        break;
                    case SUBTYPE_MESSAGING_ALIAS_DELETE:
                        txType = Messaging.ALIAS_DELETE;
                        break;
                    case SUBTYPE_MESSAGING_PHASING_VOTE_CASTING:
                        txType = Messaging.PHASING_VOTE_CASTING;
                        break;
                }
                break;
            case TYPE_COLORED_COINS:
                switch (subtype) {
                    case SUBTYPE_COLORED_COINS_ASSET_ISSUANCE:
                        txType = ColoredCoins.ASSET_ISSUANCE;
                        break;
                    case SUBTYPE_COLORED_COINS_ASSET_TRANSFER:
                        txType = ColoredCoins.ASSET_TRANSFER;
                        break;
                    case SUBTYPE_COLORED_COINS_ASK_ORDER_PLACEMENT:
                        txType = ColoredCoins.ASK_ORDER_PLACEMENT;
                        break;
                    case SUBTYPE_COLORED_COINS_BID_ORDER_PLACEMENT:
                        txType = ColoredCoins.BID_ORDER_PLACEMENT;
                        break;
                    case SUBTYPE_COLORED_COINS_ASK_ORDER_CANCELLATION:
                        txType = ColoredCoins.ASK_ORDER_CANCELLATION;
                        break;
                    case SUBTYPE_COLORED_COINS_BID_ORDER_CANCELLATION:
                        txType = ColoredCoins.BID_ORDER_CANCELLATION;
                        break;
                    case SUBTYPE_COLORED_COINS_DIVIDEND_PAYMENT:
                        txType = ColoredCoins.DIVIDEND_PAYMENT;
                        break;
                }
                break;
            case TYPE_DIGITAL_GOODS:
                switch (subtype) {
                    case SUBTYPE_DIGITAL_GOODS_LISTING:
                        txType = DigitalGoods.LISTING;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_DELISTING:
                        txType = DigitalGoods.DELISTING;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_PRICE_CHANGE:
                        txType = DigitalGoods.PRICE_CHANGE;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_QUANTITY_CHANGE:
                        txType = DigitalGoods.QUANTITY_CHANGE;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_PURCHASE:
                        txType = DigitalGoods.PURCHASE;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_DELIVERY:
                        txType = DigitalGoods.DELIVERY;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_REFUND:
                        txType = DigitalGoods.REFUND;
                        break;
                    case SUBTYPE_DIGITAL_GOODS_FEEDBACK:
                        txType = DigitalGoods.FEEDBACK;
                        break;
                }
                break;
            case TYPE_ACCOUNT_CONTROL:
                switch (subtype) {
                    case SUBTYPE_ACCOUNT_CONTROL_EFFECTIVE_BALANCE_LEASING:
                        txType = AccountControl.EFFECTIVE_BALANCE_LEASING;
                        break;
                }
                break;
            case TYPE_MONETARY_SYSTEM:
                switch (subtype) {
                    case SUBTYPE_MONETARY_SYSTEM_CURRENCY_ISSUANCE:
                        txType = MonetarySystem.CURRENCY_ISSUANCE;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_RESERVE_INCREASE:
                        txType = MonetarySystem.RESERVE_INCREASE;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_RESERVE_CLAIM:
                        txType = MonetarySystem.RESERVE_CLAIM;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_CURRENCY_TRANSFER:
                        txType = MonetarySystem.CURRENCY_TRANSFER;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_PUBLISH_EXCHANGE_OFFER:
                        txType = MonetarySystem.PUBLISH_EXCHANGE_OFFER;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_EXCHANGE_BUY:
                        txType = MonetarySystem.EXCHANGE_BUY;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_EXCHANGE_SELL:
                        txType = MonetarySystem.EXCHANGE_SELL;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_CURRENCY_MINTING:
                        txType = MonetarySystem.CURRENCY_MINTING;
                        break;
                    case SUBTYPE_MONETARY_SYSTEM_CURRENCY_DELETION:
                        txType = MonetarySystem.CURRENCY_DELETION;
                        break;
                }
            case TYPE_DATA:
                switch (subtype) {
                    case SUBTYPE_DATA_TAGGED_DATA_UPLOAD:
                        txType = Data.TAGGED_DATA_UPLOAD;
                        break;
                    case SUBTYPE_DATA_TAGGED_DATA_EXTEND:
                        txType = Data.TAGGED_DATA_EXTEND;
                        break;
                }
        }
        return txType;
    }

    /**
     * Return the transaction type
     *
     * @return                              Transaction type
     */
    public abstract byte getType();

    /**
     * Return the transaction subtype
     *
     * @return                              Transaction subtype
     */
    public abstract byte getSubtype();

    /**
     * Return the transaction description
     *
     * @return                              Transaction description
     */
    public abstract String getDescription();

    /**
     * Create an attachment from the JSON response
     *
     * @param       response                JSON response
     * @return                              Attachment or null if the transaction type does not have an attachment
     * @throws      IdentifierException     Invalid object identifier
     * @throws      NumberFormatException   Invalid numeric string
     * @throws      NxtException            Invalid peer response
     */
    public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
        return null;
    }

    /**
     * Return the transaction type hash code
     *
     * @return                              Hash code
     */
    @Override
    public int hashCode() {
        return (getType()<<8) | getSubtype();
    }

    /**
     * Check if two transaction types are equals
     *
     * @param       obj                     Transaction type to check
     * @return                              TRUE if the transaction types are equal
     */
    @Override
    public boolean equals(Object obj) {
        return (obj!=null && (obj instanceof TransactionType) && hashCode()==((TransactionType)obj).hashCode());
    }

    /**
     * Payment transactions
     */
    public static abstract class Payment extends TransactionType {
        
        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_PAYMENT;
        }

        /**
         * Ordinary payment
         */
        public static final TransactionType ORDINARY = new Payment() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_PAYMENT_ORDINARY_PAYMENT;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Ordinary payment";
            }
        };
    }

    /**
     * Messaging transactions
     */
    public static abstract class Messaging extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_MESSAGING;
        }

        /**
         * Arbitrary message
         */
        public static final TransactionType ARBITRARY_MESSAGE = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ARBITRARY_MESSAGE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Arbitrary message";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new ArbitraryMessage(response);
            }
        };

        /**
         * Alias assignment
         */
        public static final TransactionType ALIAS_ASSIGNMENT = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ALIAS_ASSIGNMENT;
            }
            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Alias assignment";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new AliasAssignment(response);
            }
        };

        /**
         * Alias buy
         */
        public static final TransactionType ALIAS_BUY = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ALIAS_BUY;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Alias buy";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new AliasBuy(response);
            }
        };

        /**
         * Alias sell
         */
        public static final TransactionType ALIAS_SELL = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ALIAS_SELL;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Alias sell";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new AliasSell(response);
            }
        };

        /**
         * Delete alias
         */
        public static final TransactionType ALIAS_DELETE = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ALIAS_DELETE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Delete alias";
            }
        };

        /**
         * Poll creation
         */
        public static final TransactionType POLL_CREATION = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_POLL_CREATION;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Poll creation";
            }
        };

        /**
         * Vote casting
         */
        public static final TransactionType VOTE_CASTING = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_VOTE_CASTING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Vote casting";
            }
        };

        /**
         * Phasing vote casting
         */
        public static final TransactionType PHASING_VOTE_CASTING = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_PHASING_VOTE_CASTING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Phasing vote casting";
            }
        };

        /**
         * Hub announcement
         */
        public static final TransactionType HUB_ANNOUNCEMENT = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_HUB_ANNOUNCEMENT;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Hub terminal announcement";
            }
        };

        /**
         * Account information
         */
        public static final TransactionType ACCOUNT_INFO = new Messaging() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MESSAGING_ACCOUNT_INFO;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Account information";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new AccountInfo(response);
            }
        };
    }

    /**
     * Colored coin transactions
     */
    public static abstract class ColoredCoins extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_COLORED_COINS;
        }

        /**
         * Asset issuance
         */
        public static final TransactionType ASSET_ISSUANCE = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_ASSET_ISSUANCE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Asset issuance";
            }
        };

        /**
         * Asset transfer
         */
        public static final TransactionType ASSET_TRANSFER = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_ASSET_TRANSFER;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Asset transfer";
            }
        };

        /**
         * Ask order placement
         */
        public static final TransactionType ASK_ORDER_PLACEMENT = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_ASK_ORDER_PLACEMENT;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Ask order placement";
            }
        };

        /**
         * Bid order placement
         */
        public static final TransactionType BID_ORDER_PLACEMENT = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_BID_ORDER_PLACEMENT;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Bid order placement";
            }
        };

        /**
         * Ask order cancellation
         */
        public static final TransactionType ASK_ORDER_CANCELLATION = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_ASK_ORDER_CANCELLATION;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Ask order cancellation";
            }
        };

        /**
         * Bid order cancellation
         */
        public static final TransactionType BID_ORDER_CANCELLATION = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_BID_ORDER_CANCELLATION;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Bid order cancellation";
            }
        };

        /**
         * Dividend payment
         */
        public static final TransactionType DIVIDEND_PAYMENT = new ColoredCoins() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_COLORED_COINS_DIVIDEND_PAYMENT;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Dividend payment";
            }
        };
    }

    /**
     * Digital goods transactions
     */
    public static abstract class DigitalGoods extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_DIGITAL_GOODS;
        }

        /**
         * Digital goods listing
         */
        public static final TransactionType LISTING = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_LISTING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods listing";
            }
        };

        /**
         * Digital goods delisting
         */
        public static final TransactionType DELISTING = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_DELISTING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods delisting";
            }
        };

        /**
         * Digital goods price change
         */
        public static final TransactionType PRICE_CHANGE = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_PRICE_CHANGE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods price change";
            }
        };

        /**
         * Digital goods quantity change
         */
        public static final TransactionType QUANTITY_CHANGE = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_QUANTITY_CHANGE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods quantity change";
            }
        };

        /**
         * Digital goods purchase
         */
        public static final TransactionType PURCHASE = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_PURCHASE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods purchase";
            }
        };

        /**
         * Digital goods delivery
         */
        public static final TransactionType DELIVERY = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_DELIVERY;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods delivery";
            }
        };

        /**
         * Digital goods feedback
         */
        public static final TransactionType FEEDBACK = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_FEEDBACK;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods feedback";
            }
        };

        /**
         * Digital goods refund
         */
        public static final TransactionType REFUND = new DigitalGoods() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DIGITAL_GOODS_REFUND;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Digital goods refund";
            }
        };
    }

    /**
     * Account control transactions
     */
    public static abstract class AccountControl extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_ACCOUNT_CONTROL;
        }

        /**
         * Effective balance leasing
         */
        public static final TransactionType EFFECTIVE_BALANCE_LEASING = new AccountControl() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_ACCOUNT_CONTROL_EFFECTIVE_BALANCE_LEASING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Balance leasing";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new BalanceLeasing(response);
            }
        };
    }

    /**
     * Monetary system transactions
     */
    public static abstract class MonetarySystem extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_MONETARY_SYSTEM;
        }

        /**
         * Issue currency
         */
        public static final TransactionType CURRENCY_ISSUANCE = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_CURRENCY_ISSUANCE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Issue currency";
            }
        };

        /**
         * Increase reserve
         */
        public static final TransactionType RESERVE_INCREASE = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_RESERVE_INCREASE;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Increase currency reserve";
            }
        };

        /**
         * Claim reserve
         */
        public static final TransactionType RESERVE_CLAIM = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_RESERVE_CLAIM;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Claim currency reserve";
            }
        };

        /**
         * Transfer currency
         */
        public static final TransactionType CURRENCY_TRANSFER = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_CURRENCY_TRANSFER;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Transfer currency";
            }
        };

        /**
         * Publish exchange offer
         */
        public static final TransactionType PUBLISH_EXCHANGE_OFFER = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_PUBLISH_EXCHANGE_OFFER;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Publish exchange offer";
            }
        };

        /**
         * Buy currency
         */
        public static final TransactionType EXCHANGE_BUY = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_EXCHANGE_BUY;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Buy currency";
            }
        };

        /**
         * Sell currency
         */
        public static final TransactionType EXCHANGE_SELL = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_EXCHANGE_SELL;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Sell currency";
            }
        };

        /**
         * Mint currency
         */
        public static final TransactionType CURRENCY_MINTING = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_CURRENCY_MINTING;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Mint currency";
            }

            /**
             * Create an attachment from the JSON response
             *
             * @param       response                JSON response
             * @return                              Attachment
             * @throws      IdentifierException     Invalid object identifier
             * @throws      NumberFormatException   Invalid numeric string
             * @throws      NxtException            Invalid peer response
             */
            @Override
            public Attachment loadAttachment(PeerResponse response) throws IdentifierException, NumberFormatException, NxtException {
                return new CurrencyMinting(response);
            }
        };

        /**
         * Delete currency
         */
        public static final TransactionType CURRENCY_DELETION = new MonetarySystem() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_MONETARY_SYSTEM_CURRENCY_DELETION;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Delete currency";
            }
        };
    }

    /**
     * Data transactions
     */
    public static abstract class Data extends TransactionType {

        /**
         * Return the transaction type
         *
         * @return                      Transaction type
         */
        @Override
        public byte getType() {
            return TYPE_DATA;
        }

        /**
         * Tagged data upload
         */
        public static final TransactionType TAGGED_DATA_UPLOAD = new Data() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DATA_TAGGED_DATA_UPLOAD;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Tagged data upload";
            }
        };

        /**
         * Tagged data extend
         */
        public static final TransactionType TAGGED_DATA_EXTEND = new Data() {

            /**
             * Return the transaction subtype
             *
             * @return                  Transaction subtype
             */
            @Override
            public byte getSubtype() {
                return SUBTYPE_DATA_TAGGED_DATA_EXTEND;
            }

            /**
             * Return the transaction description
             *
             * @return                  Transaction description
             */
            @Override
            public String getDescription() {
                return "Tagged data extend";
            }
        };
    }
}
