INSERT INTO `restaurant` (`id`, `created_at`, `name`, `updated_at`, `open`, `close`) VALUES ('1', '2019-01-22 01:10:00', 'Metro Capão', '2019-01-22 01:10:00', '00:01:00.000', '23:59:00.000');
INSERT INTO `contact` (`id`, `created_at`, `name`, `number`, `type`, `updated_at`, `restaurant_id`) VALUES ('1', '2019-01-22 01:10:00', 'Douglas', '1', '1', '2019-01-22 01:10:00', '1');
INSERT INTO `address` (`id`, `city`, `complement`, `country`, `created_at`, `district`, `latitude`, `longitude`, `number`, `street`, `updated_at`, `zip_code`, `restaurant_id`) VALUES ('1', 'São Paulo', 'Coimbra', 'SP', '2019-01-22 01:10:00', 'São Paulo', '-23.6864837', '-46.7800381', '1', '1', '2019-01-22 01:10:00', '1', '1');